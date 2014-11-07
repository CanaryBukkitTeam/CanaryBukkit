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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

public class CanaryPigZombie extends CanaryZombie implements PigZombie
{
    private net.canarymod.api.entity.living.monster.PigZombie entity;

    public CanaryPigZombie(net.canarymod.api.entity.living.monster.PigZombie entity) {
        super(entity);
        this.entity = entity;
    }

    public int getAnger()
    {
        return entity.getAngerLevel();
    }

    @Override
    public EntityType getType()
    {
        return EntityType.PIG_ZOMBIE;
    }

    public boolean isAngry()
    {
        return entity.isAngry();
    }

    public void setAnger(int level)
    {
        entity.setAngerLevel(level);
    }

    public void setAngry(boolean angry)
    {
        setAnger(angry ? 400 : 0);
    }
}
