package com.github.maikishiti.testgame.screen

import com.badlogic.gdx.graphics.g2d.Batch
import com.github.maikishiti.testgame.Main
import ktx.app.KtxScreen

abstract class InstanceScreen(
    val game: Main,
    val batch: Batch = game.batch
    ) : KtxScreen