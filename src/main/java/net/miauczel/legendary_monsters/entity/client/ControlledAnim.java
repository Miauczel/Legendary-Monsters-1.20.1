package net.miauczel.legendary_monsters.entity.client;

public class ControlledAnim { /**
 * It is the timer used to animate
 */
private int timer;
    private int prevtimer;

    /**
     * It is the limit time, the maximum value that the timer can be. I represents the duration of the
     * animation
     */
    private int duration;

    private int timerChange;

    public ControlledAnim(int tickDuration) {
        timer = 0;
        prevtimer = 0;
        duration = tickDuration;
    }

    /**
     * Sets the duration of the animation in ticks. Try values around 50.
     *
     * @param d is the maximum number of ticks that the timer can reach.
     */
    public void setDuration(int d) {
        timer = 0;
        prevtimer = 0;
        duration = d;
    }

    /**
     * Returns the timer of this animation. Useful to save the progress of the animation.
     */
    public int getTimer() {
        return timer;
    }

    public int getPrevTimer() {
        return prevtimer;
    }

    /**
     * Sets the timer to a specific value.
     *
     * @param time is the number of ticks to be set.
     */
    public void setTimer(int time) {
        timer = time;
        prevtimer = time;

        if (timer > duration) {
            timer = duration;
        } else if (timer < 0) {
            timer = 0;
        }
    }

    /**
     * Sets the timer to 0.
     */

    public void resetTimer() {
        timer = 0;
        prevtimer = 0;
    }

    /**
     * Increases the timer by 1.
     */
    public void increaseTimer() {
        if (timer < duration) {
            timer++;
            timerChange = 1;
        }
    }

    /**
     * Checks if the timer can be increased
     */
    public boolean canIncreaseTimer() {
        return timer < duration;
    }

    /**
     * Increases the timer by a specific value.
     *
     * @param time is the number of ticks to be increased in the timer
     */
    public void increaseTimer(int time) {
        int newTime = timer + time;
        if (newTime <= duration && newTime >= 0) {
            timer = newTime;
        } else {
            timer = newTime < 0 ? 0 : duration;
        }
    }

    /**
     * Decreases the timer by 1.
     */
    public void decreaseTimer() {
        if (timer > 0.0D) {
            timer--;
            timerChange = -1;
        }
    }

    /**
     * Checks if the timer can be decreased
     */
    public boolean canDecreaseTimer() {
        return timer > 0.0D;
    }

    /**
     * Decreases the timer by a specific value.
     *
     * @param time is the number of ticks to be decreased in the timer
     */
    public void decreaseTimer(int time) {
        if (timer - time > 0.0D) {
            timer -= time;
        } else {
            timer = 0;
        }
    }

    public float getAnimationFraction() {
        return this.timer / (float) this.duration;
    }

}
