package CommonsObjects;

import visitors.Ivisitor;

/**
 * @author Carlo Maria Zw�lf, Lerma/ObsPM
 * 
 *         Class describing general parameters wich may be both input and
 *         outputs of a Job Object.
 */
public class GeneralParameter {

	/**
	 * The value attribute corresponds is the String containing the value. E.g.
	 * if your value is the integer 3, then the String value is "3"
	 */
	private String value;

	/**
	 * The type attribute describe the type of the value, whose value is
	 * contained in the value attribute. E.g. if your value is the integer 3,
	 * then the String value is "Integer"
	 */
	private String type;

	/**
	 * This attribute contains the functional description of parameter provided
	 * by user
	 */
	private String description;

	/**
	 * @param value
	 * @param type
	 * @param description
	 * @param visitor
	 *            . This attribute is an object implementing the Ivisitor
	 *            interface. This last interface is designed for implementing
	 *            the Visitor design patern. The visitor implementing instance
	 *            will be used for checking the validity of the data contained
	 *            in the GeneralParameter attributes.
	 */
	public GeneralParameter(String value, String type, String description,
			Ivisitor visitor) {
		super();
		this.value = value;
		this.type = type;
		this.description = description;

		// Calling the verifing methods defined throw the 'visitor'
		this.verifyParameter(visitor);
	}

	/**
	 * This functions calls the visit method of the provided visitor
	 * implementation for verifying the validity of data.
	 */
	public void verifyParameter(Ivisitor visitor) {
		visitor.visit(this);
	}

	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

}