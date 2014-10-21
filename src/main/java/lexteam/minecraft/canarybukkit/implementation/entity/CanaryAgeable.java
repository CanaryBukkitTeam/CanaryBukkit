/**
 * This file is part of CanaryBukkit, a CanaryLib plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit.implementation.entity;

import net.canarymod.api.entity.living.LivingBase;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ageable;

public class CanaryAgeable extends CanaryCreature implements Ageable
{
    private LivingBase entity;

    public CanaryAgeable(net.canarymod.api.entity.living.LivingBase entity) {
        super(entity);
        this.entity = entity;
    }

    public boolean canBreed()
    {
        return getAge() == 0;
    }

    public int getAge()
    {
        if (entity instanceof net.canarymod.api.entity.living.Ageable) {
            return ((net.canarymod.api.entity.living.Ageable) entity).getGrowingAge();
        } else {
            return 0;
        }
    }

    public boolean getAgeLock()
    {
        return false;
    }

    public boolean isAdult()
    {
        return getAge() >= 0;
    }

    public void setAdult()
    {
        if (!isAdult()) {
            setAge(0);
        }
    }

    public void setAge(int age)
    {
        if (entity instanceof net.canarymod.api.entity.living.Ageable) {
            ((net.canarymod.api.entity.living.Ageable) entity).setGrowingAge(age);
        }
    }

    public void setAgeLock(boolean lock)
    {
        throw new NotImplementedException();
    }

    public void setBaby()
    {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    public void setBreed(boolean breed)
    {
        throw new NotImplementedException();
    }
}