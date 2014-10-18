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

import org.bukkit.entity.Villager;
import org.bukkit.entity.EntityType;

public class CanaryVillager extends CanaryAgeable implements Villager {
    private net.canarymod.api.entity.living.humanoid.Villager entity;

    public CanaryVillager(net.canarymod.api.entity.living.humanoid.Villager entity) {
        super(entity);
        this.entity = entity;
    }

    public Profession getProfession() {
        switch (entity.getProfession()) {
            case BLACKSMITH:
                return Profession.BLACKSMITH;
            case BUTCHER:
                return Profession.BUTCHER;
            case FARMER:
                return Profession.FARMER;
            case LIBRARIAN:
                return Profession.LIBRARIAN;
            case PRIEST:
                return Profession.PRIEST;
            case VILLAGER:
            default:
                return Profession.FARMER;
        }
    }

    public void setProfession(Profession profession) {
        switch (profession) {
            case BLACKSMITH:
                entity.setProfession(net.canarymod.api.entity.living.humanoid.Villager.Profession.BLACKSMITH);
                break;
            case BUTCHER:
                entity.setProfession(net.canarymod.api.entity.living.humanoid.Villager.Profession.BUTCHER);
                break;
            case FARMER:
                entity.setProfession(net.canarymod.api.entity.living.humanoid.Villager.Profession.FARMER);
                break;
            case LIBRARIAN:
                entity.setProfession(net.canarymod.api.entity.living.humanoid.Villager.Profession.LIBRARIAN);
                break;
            case PRIEST:
                entity.setProfession(net.canarymod.api.entity.living.humanoid.Villager.Profession.PRIEST);
                break;
        }
    }

    public EntityType getType() {
        return EntityType.VILLAGER;
    }
}