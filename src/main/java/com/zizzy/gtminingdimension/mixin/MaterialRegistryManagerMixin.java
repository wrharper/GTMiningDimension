package com.zizzy.gtminingdimension.mixin;

import com.gregtechceu.gtceu.common.material.MaterialRegistryManager;
import com.gregtechceu.gtceu.api.material.material.IMaterialRegistryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MaterialRegistryManager.class)
public class MaterialRegistryManagerMixin {
    @Inject(method = "getPhase", at = @At("HEAD"), cancellable = true)
    private void forceOpenPhase(CallbackInfoReturnable<IMaterialRegistryManager.Phase> info) {
        info.setReturnValue(IMaterialRegistryManager.Phase.PRE);
        System.out.println("GTCEu material registration forced into OPEN phase.");
    }
}
