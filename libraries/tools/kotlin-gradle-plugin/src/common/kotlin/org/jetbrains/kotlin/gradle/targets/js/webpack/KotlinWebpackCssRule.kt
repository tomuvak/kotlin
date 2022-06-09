/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.targets.js.webpack

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.jetbrains.kotlin.gradle.targets.js.NpmVersions
import org.jetbrains.kotlin.gradle.targets.js.RequiredKotlinJsDependency
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackCssMode.EXTRACT
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackCssMode.IMPORT
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackCssMode.INLINE

@Deprecated(
    message = "Renamed to KotlinWebpackCssRule", replaceWith = ReplaceWith(
        expression = "KotlinWebpackCssRule",
        imports = arrayOf("org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackCssRule")
    )
)
typealias KotlinWebpackCssSupport = KotlinWebpackCssRule

@Suppress("LeakingThis")
abstract class KotlinWebpackCssRule : KotlinWebpackRule() {
    @get:Input
    abstract val mode: Property<String>

    init {
        mode.convention(INLINE)
        test.convention("/\\.css\$/")
    }

    override fun dependencies(versions: NpmVersions): Collection<RequiredKotlinJsDependency> {
        return mutableListOf<RequiredKotlinJsDependency>().apply {
            add(versions.cssLoader)
            when (mode.get()) {
                EXTRACT -> add(versions.miniCssExtractPlugin)
                INLINE -> add(versions.styleLoader)
                IMPORT -> add(versions.toStringLoader)
            }
        }
    }

    override fun validate(): Boolean {
        if (mode.get() !in arrayOf(EXTRACT, INLINE, IMPORT)) {
            error(
                """
                Possible values for cssSupport.mode:
                - EXTRACT
                - INLINE
                - IMPORT
                """.trimIndent()
            )
        }
        return true
    }

    override fun buildLoaders(): List<Loader> = when (mode.get()) {
        EXTRACT -> listOf(
            Loader(
                value = "MiniCssExtractPlugin.loader",
                prerequisites = listOf(
                    "const MiniCssExtractPlugin = require('mini-css-extract-plugin');",
                    "config.plugins.push(new MiniCssExtractPlugin())"
                )
            ),
        )

        INLINE -> listOf(Loader(value = "'style-loader'"))
        IMPORT -> listOf(Loader(value = "'to-string-loader'"))
        else -> listOf()
    }
}

object KotlinWebpackCssMode {
    const val EXTRACT = "extract"
    const val INLINE = "inline"
    const val IMPORT = "import"
}
