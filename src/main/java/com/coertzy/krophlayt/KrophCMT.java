package com.coertzy.krophlayt;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class KrophCMT {
    public static final CreativeModeTab KROPHLAYT = new CreativeModeTab("krophlayt") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ACACIA_LOG);
        }
    };
}
