package OOPs.InheritanceExample;

/**
 * Represents a television that can be turned up/down and on/off.
 * 
 * @author imodm
 *
 */
public class TV implements Powerable, Audible {

	private float volume;
	private boolean power;

	@Override
	public float getVolume() {
		return volume;
	}

	@Override
	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Override
	public boolean isPowered() {
		return power;
	}

	@Override
	public void setPowered(boolean power) {
		this.power = power;
	}

}
