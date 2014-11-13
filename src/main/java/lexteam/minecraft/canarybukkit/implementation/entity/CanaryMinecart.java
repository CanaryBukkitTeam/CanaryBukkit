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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;

public abstract class CanaryMinecart extends CanaryVehicle implements Minecart
{
    public CanaryMinecart(net.canarymod.api.entity.vehicle.Minecart entity) {
        super(entity);
    }

    public void _INVALID_setDamage(int damage)
    {
        throw new NotImplementedException();
    }

    public void setDamage(double damage)
    {
        throw new NotImplementedException();
    }

    public int _INVALID_getDamage()
    {
        throw new NotImplementedException();
    }

    public double getDamage()
    {
        throw new NotImplementedException();
    }

    public double getMaxSpeed()
    {
        throw new NotImplementedException();
    }

    public void setMaxSpeed(double speed)
    {
        throw new NotImplementedException();
    }

    public boolean isSlowWhenEmpty()
    {
        throw new NotImplementedException();
    }

    public void setSlowWhenEmpty(boolean slow)
    {
        throw new NotImplementedException();
    }

    public Vector getFlyingVelocityMod()
    {
        throw new NotImplementedException();
    }

    public void setFlyingVelocityMod(Vector flying)
    {
        throw new NotImplementedException();
    }

    public Vector getDerailedVelocityMod()
    {
        throw new NotImplementedException();
    }

    public void setDerailedVelocityMod(Vector derailed)
    {
        throw new NotImplementedException();
    }
}
