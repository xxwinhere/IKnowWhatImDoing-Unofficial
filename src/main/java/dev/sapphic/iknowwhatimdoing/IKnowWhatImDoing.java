/*
 * Copyright 2022 Chloe Dawn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.sapphic.iknowwhatimdoing;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.tutorial.TutorialSteps;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkConstants;

import java.io.Serial;
import java.io.Serializable;

@Mod("iknowwhatimdoing")
public final class IKnowWhatImDoing implements Serializable {
  @Serial private static final long serialVersionUID = -8646731113218545455L;

  public IKnowWhatImDoing() {
    ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> {
      return new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (s, v) -> true);
    });

    if (FMLLoader.getDist() == Dist.CLIENT) {
      MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST, true, (ScreenEvent.Opening event) -> {
        if (event.getScreen() instanceof TitleScreen) {
          Minecraft.getInstance().getTutorial().setStep(TutorialSteps.NONE);
        }
      });
    }
  }
}
