package com.laytonsmith.abstraction.events;

import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.blocks.MCBlockState;
import com.laytonsmith.abstraction.enums.MCEquipmentSlot;
import com.laytonsmith.core.events.BindableEvent;

/**
 *
 * @author EntityReborn
 */
public interface MCBlockPlaceEvent extends BindableEvent{

    public MCPlayer getPlayer();

    public MCBlock getBlock();

    public MCBlock getBlockAgainst();

    public MCBlockState getBlockReplacedState();

    public MCItemStack getItemInHand();

    public boolean canBuild();
}