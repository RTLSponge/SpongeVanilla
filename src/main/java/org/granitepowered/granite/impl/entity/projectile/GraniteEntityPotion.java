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

package org.granitepowered.granite.impl.entity.projectile;

import org.apache.commons.lang3.NotImplementedException;
import org.granitepowered.granite.mc.MCEntityPotion;
import org.granitepowered.granite.mc.MCItemStack;
import org.granitepowered.granite.util.MinecraftUtils;
import org.spongepowered.api.entity.projectile.ThrownPotion;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;

import java.util.List;

public class GraniteEntityPotion extends GraniteEntityThrowable<MCEntityPotion> implements ThrownPotion {

    public GraniteEntityPotion(MCEntityPotion obj) {
        super(obj);
    }

    @Override
    public ItemStack getItem() {
        return MinecraftUtils.wrap(obj.fieldGet$potionDamage());
    }

    @Override
    public void setItem(ItemStack itemStack) {
        obj.fieldSet$potionDamage((MCItemStack) MinecraftUtils.unwrap(itemStack));
    }

    @Override
    public List<PotionEffect> getPotionEffects() {
        throw new NotImplementedException("");
    }
}
