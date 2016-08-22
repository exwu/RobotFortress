package game_logic

import com.badlogic.gdx.graphics.g2d.SpriteBatch

import scala.util.Random

/**
  * Created by Emily on 8/21/2016.
  */

object Components {
  /**
    * list of all component keys
    */
  val TICK_TYPE = "tick_type"
  val NAME = "name"
  val ID = "id"
  val COLOR = "color"
  val HEALTH = "health"
  val SPEED = "speed"
  val SENTIENCE = "sentience"
  val POS_X = "position_x"
  val POS_Y = "position_y"
  val POS_Z = "position_z"
}


object GameInstance {
  var entities: List[Entity] = List()
  var map: Map[(Int, Int, Int),List[Entity]] = Map()

  def addToMap(entity: Entity, x: Int, y: Int, z:Int): Unit = {
    val entList = entity :: GameInstance.map.getOrElse((x, y, z), List())
    GameInstance.map += ((x, y, z) -> entList)
  }
}

object RobotFactory {
  def makeRobot(): Entity = {
    val id = Random.nextInt()
    val ent = new Entity(id)
    ent.add(Components.NAME, "Robo-" + id)
    ent.add(Components.COLOR, "red")
    ent.add(Components.HEALTH, 100)
    ent.add(Components.SPEED, 10.0f)
    ent.add(Components.SENTIENCE, 0.5f)

    val x = 0
    val y = 0
    val z = 0
    ent.add(Components.POS_X, x)
    ent.add(Components.POS_Y, y)
    ent.add(Components.POS_Z, z)

    GameInstance.addToMap(ent, x, y, z)
    ent
  }

  def makeDeadRobot(): Entity = {
    val ent = makeRobot()
    ent.add(Components.HEALTH, 0)
    ent
  }
}

object RenderSystem {

  def update(batch : SpriteBatch): Unit = {
    for (entity <- GameInstance.entities) {
      // batch.draw(getTexture(entity), entity.getFloat(Components.POS_X))
    }
  }
}

object AISystem {

  def update(): Unit = {
    for (entity <- GameInstance.entities) {
      entity.getFloat(Components.SENTIENCE) match {
        case None => ()
        case Some(x) =>
      }
    }
  }
}

