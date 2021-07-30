/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations.persistent

import org.jetbrains.kotlin.descriptors.DescriptorVisibility
import org.jetbrains.kotlin.ir.declarations.IrAttributeContainer
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.declarations.IrDeclarationParent
import org.jetbrains.kotlin.ir.declarations.IrField
import org.jetbrains.kotlin.ir.declarations.IrProperty
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.declarations.MetadataSource
import org.jetbrains.kotlin.ir.declarations.persistent.carriers.Carrier
import org.jetbrains.kotlin.ir.declarations.persistent.carriers.PropertyCarrier
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.symbols.IrFieldSymbol
import org.jetbrains.kotlin.ir.symbols.IrPropertySymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol
import org.jetbrains.kotlin.ir.util.IdSignature
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedContainerSource

// Auto-generated by compiler/ir/ir.tree.persistent/generator/src/org/jetbrains/kotlin/ir/persistentIrGenerator/Main.kt. DO NOT EDIT!

internal abstract class PersistentIrPropertyCommon(
    override val startOffset: Int,
    override val endOffset: Int,
    origin: IrDeclarationOrigin,
    override val name: Name,
    override var visibility: DescriptorVisibility,
    override val isVar: Boolean,
    override val isConst: Boolean,
    override val isLateinit: Boolean,
    override val isDelegated: Boolean,
    override val isExternal: Boolean,
    override val isExpect: Boolean,
    override val containerSource: DeserializedContainerSource?,
    override val factory: PersistentIrFactory
) : IrProperty(),
    PersistentIrDeclarationBase<PropertyCarrier>,
    PropertyCarrier {

    override var signature: IdSignature? = factory.currentSignature(this)

    override var lastModified: Int = factory.stageController.currentStage
    override var loweredUpTo: Int = factory.stageController.currentStage
    override var values: Array<Carrier>? = null
    override val createdOn: Int = factory.stageController.currentStage

    override var parentField: IrDeclarationParent? = null
    override var originField: IrDeclarationOrigin = origin
    override var removedOn: Int = Int.MAX_VALUE
    override var annotationsField: List<IrConstructorCall> = emptyList()
    private val hashCodeValue: Int = PersistentIrDeclarationBase.hashCodeCounter++
    override fun hashCode(): Int = hashCodeValue
    override fun equals(other: Any?): Boolean = (this === other)

    override var backingFieldField: IrField? = null

    override var backingFieldSymbolField: IrFieldSymbol?
        get() = backingFieldField?.symbol
        set(v) {
            backingFieldField = v?.owner
        }

    override var backingField: IrField?
        get() = getCarrier().backingFieldField
        set(v) {
            if (backingField !== v) {
                setCarrier()
                backingFieldField = v
            }
        }

    override var getterField: IrSimpleFunction? = null

    override var getterSymbolField: IrSimpleFunctionSymbol?
        get() = getterField?.symbol
        set(v) {
            getterField = v?.owner
        }

    override var getter: IrSimpleFunction?
        get() = getCarrier().getterField
        set(v) {
            if (getter !== v) {
                setCarrier()
                getterField = v
            }
        }

    override var setterField: IrSimpleFunction? = null

    override var setterSymbolField: IrSimpleFunctionSymbol?
        get() = setterField?.symbol
        set(v) {
            setterField = v?.owner
        }

    override var setter: IrSimpleFunction?
        get() = getCarrier().setterField
        set(v) {
            if (setter !== v) {
                setCarrier()
                setterField = v
            }
        }

    override var overriddenSymbolsField: List<IrPropertySymbol> = emptyList()

    override var overriddenSymbols: List<IrPropertySymbol>
        get() = getCarrier().overriddenSymbolsField
        set(v) {
            if (overriddenSymbols !== v) {
                setCarrier()
                overriddenSymbolsField = v
            }
        }

    override var metadata: MetadataSource? = null

    @Suppress("LeakingThis")
    override var attributeOwnerId: IrAttributeContainer = this
}
