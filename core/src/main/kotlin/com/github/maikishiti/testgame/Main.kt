package com.github.maikishiti.testgame

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.github.maikishiti.testgame.screen.GameScreen
import com.github.maikishiti.testgame.screen.InstanceScreen
import ktx.app.KtxGame
import ktx.log.logger

const val UNIT_SCALE: Float = 1f/16f
private val LOG = logger<Main>()

class Main : KtxGame<InstanceScreen>() {
    val batch : Batch  by lazy { SpriteBatch () }
    val engine: Engine by lazy { PooledEngine() }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG

        LOG.debug{ "Created Game Instance" }
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        super.dispose()
        LOG.debug{ "Disposed ${(batch as SpriteBatch).maxSpritesInBatch} sprites from batch $batch" }
        batch.dispose()
    }
}