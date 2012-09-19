package se.digiplant.scalr.api

import org.specs2.mutable.Specification
import play.api.test._
import play.api.test.Helpers._

object ScalrAssetsSpec extends Specification {

  "Scalr Controller" should {

    "return resized image" in {
      val ctx = new ScalrContext
      running(ctx.app) {

        val result = ScalrAssets.at("/src/test/resources", "digiPlant.jpg", 50, 50)(FakeRequest())

        status(result) must equalTo(OK)
        contentType(result) must beSome("image/jpeg")
      }
    }

    "return resized image in subfolder" in {
      val ctx = new ScalrContext
      running(ctx.app) {

        val result = ScalrAssets.at("/src/test/resources", "subdir/test.jpg", 50, 50)(FakeRequest())

        status(result) must equalTo(OK)
        contentType(result) must beSome("image/jpeg")
      }
    }

  }
}
