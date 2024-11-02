package ca.sheridancollege.makaju.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Gadget {
	private int ID;
	private String Name;
	private String Price;
	private String Durability;
	private String Range;
	private String Weight;
	private String Special_Abilities;

}
