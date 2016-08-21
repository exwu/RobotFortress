package gdx

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Gdx, Game}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
  * Created by emily on 4/29/16.
  */
class FortressGame extends Game {

  var batch: SpriteBatch = null

  override def create(): Unit = {
    this.batch = new SpriteBatch()
    this.setScreen(new WorldScreen(this))
  }

  override def render(): Unit = {
    //    super.render()

    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    //batch.draw(img, 0, 0);
    batch.end();
  }

  override def dispose(): Unit = {
    batch.dispose()
  }
}
