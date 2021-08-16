package com.github.maikishiti.testgame.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.github.maikishiti.testgame.Main
import ktx.graphics.use
import ktx.log.logger

private val LOG = logger<GameScreen>()

class GameScreen(game: Main) : InstanceScreen(game) {
    private val texture = Texture(Gdx.files.internal("Graphics/adventurer.png"))
    private val sprite = Sprite(texture)
    private var posX = 0f
    private var posY = 0f

    override fun show() {
        LOG.debug { "Game screen is shown" }
    }

    override fun render(delta: Float) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) posY+=100*delta
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) posY-=100*delta
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) posX+=100*delta
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) posX-=100*delta
        sprite.setPosition(posX,posY)
        batch.use {
            sprite.draw(it)
        }
    }

    override fun dispose() {
       texture.dispose()
    }
}