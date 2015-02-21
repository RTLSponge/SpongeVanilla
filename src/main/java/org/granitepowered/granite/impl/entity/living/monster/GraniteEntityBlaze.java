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

package org.granitepowered.granite.impl.entity.living.monster;

import com.flowpowered.math.vector.Vector3f;
import org.apache.commons.lang3.NotImplementedException;
import org.granitepowered.granite.mc.MCEntityBlaze;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.projectile.Projectile;

public class GraniteEntityBlaze extends GraniteEntityMonster<MCEntityBlaze> implements Blaze {

    public GraniteEntityBlaze(MCEntityBlaze obj) {
        super(obj);
    }

    @Override
    public boolean isOnFire() {
        return ((byte) obj.fieldGet$dataWatcher().getWatchedObject(16).fieldGet$watchedObject() & 1) != 0;
    }

    @Override
    public void setOnFire(boolean onFire) {
        obj.fieldGet$dataWatcher().updateObject(16, onFire ? (byte) 1 : (byte) 0);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<T> aClass) {
        // TODO: launch Projectiles
        throw new NotImplementedException("");
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<T> aClass, Vector3f vector3f) {
        // TODO: launch Projectiles
        throw new NotImplementedException("");
    }
}
