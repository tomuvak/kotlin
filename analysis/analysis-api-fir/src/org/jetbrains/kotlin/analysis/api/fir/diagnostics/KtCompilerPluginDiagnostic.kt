/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.diagnostics

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.analysis.api.lifetime.KtLifetimeToken
import org.jetbrains.kotlin.diagnostics.*

abstract class KtCompilerPluginDiagnostic0 : KtFirDiagnostic<PsiElement>(), KtAbstractFirDiagnostic<PsiElement> {
    final override val diagnosticClass
        get() = KtCompilerPluginDiagnostic0::class
}

abstract class KtCompilerPluginDiagnostic1 : KtFirDiagnostic<PsiElement>(), KtAbstractFirDiagnostic<PsiElement> {
    abstract val a: Any?

    final override val diagnosticClass
        get() = KtCompilerPluginDiagnostic1::class
}

abstract class KtCompilerPluginDiagnostic2 : KtFirDiagnostic<PsiElement>(), KtAbstractFirDiagnostic<PsiElement> {
    abstract val a: Any?
    abstract val b: Any?

    final override val diagnosticClass
        get() = KtCompilerPluginDiagnostic2::class
}

abstract class KtCompilerPluginDiagnostic3 : KtFirDiagnostic<PsiElement>(), KtAbstractFirDiagnostic<PsiElement> {
    abstract val a: Any?
    abstract val b: Any?
    abstract val c: Any?

    final override val diagnosticClass
        get() = KtCompilerPluginDiagnostic3::class
}

abstract class KtCompilerPluginDiagnostic4 : KtFirDiagnostic<PsiElement>(), KtAbstractFirDiagnostic<PsiElement> {
    abstract val a: Any?
    abstract val b: Any?
    abstract val c: Any?
    abstract val D: Any?

    final override val diagnosticClass
        get() = KtCompilerPluginDiagnostic4::class
}
