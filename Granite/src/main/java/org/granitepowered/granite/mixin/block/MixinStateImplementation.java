/*
 * License (MIT)
 *
 * Copyright (c) 2014-2015 Granite Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.granitepowered.granite.mixin.block;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import mc.Block;
import mc.IBlockState;
import mc.IProperty;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.api.block.BlockProperty;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NonnullByDefault
@Mixin(value = mc.BlockState.StateImplementation.class, remap = false)
public abstract class MixinStateImplementation implements BlockState, IBlockState {
    @Shadow
    private Block block;

    @Shadow
    private ImmutableMap properties;

    @Override
    public BlockType getType() {
        return (BlockType) block;
    }

    @Override
    public ImmutableMap<BlockProperty<?>, ? extends Comparable<?>> getProperties() {
        return properties;
    }

    @Override
    public Collection<String> getPropertyNames() {
        List<String> out = new ArrayList<>();
        for (Object property : properties.keySet()) {
            out.add(((BlockProperty) property).getName());
        }
        return ImmutableList.copyOf(out);
    }

    @Override
    public Optional<BlockProperty<?>> getPropertyByName(String s) {
        for (Object property : properties.keySet()) {
            if (((BlockProperty) property).getName().equals(s)) {
                return Optional.<BlockProperty<?>>of((BlockProperty<?>) property);
            }
        }
        return Optional.absent();
    }

    @Override
    public Optional<? extends Comparable<?>> getPropertyValue(String s) {
        Optional<BlockProperty<?>> property = getPropertyByName(s);
        if (!property.isPresent()) return Optional.absent();

        return Optional.<Comparable<?>>fromNullable(getValue((IProperty) property.get()));
    }

    @Override
    public BlockState withProperty(BlockProperty<?> blockProperty, Comparable<?> comparable) {
        return (BlockState) withProperty((IProperty) blockProperty, comparable);
    }

    @Override
    public BlockState cycleProperty(BlockProperty<?> blockProperty) {
        return (BlockState) cycleProperty((IProperty) blockProperty);
    }

    @Override
    public byte getDataValue() {
        throw new NotImplementedException("Deprecated");
    }
}