package com.github.maikishiti.testgame.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.github.maikishiti.testgame.Main
import ktx.log.logger

private val LOG = logger<SecondScreen>()

class SecondScreen(game: Main) : InstanceScreen(game) {
    override fun show() {
        LOG.debug { "Second screen is shown" }
    }

    override fun render(delta: Float) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            game.setScreen<FirstScreen>()
        }
    }
}