package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 09/12/2016.
 * Abstract class for the animators that move pieces around at each frame of the animations.
 */
abstract class Animator {

    abstract void executeAnimationFrame();
    int frame = 1;

}
