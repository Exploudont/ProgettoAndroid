/**
Basicc rappresentation of a Person.
*/
open class Person {

	// static components
	companion object {
		private val MIN_LENGTH = 3
		private val DEFAULT_NAME = "unknow"
		private val DEFAULT_SURNAME = "unknow"
		private val DEFAULT_BIRTHDAY = Date(2021, 1, 1)
		private val DEFAULT_SEX = Gender.NON_BINARY
	}
	
	
	private val name: String
	private val surname: String
	private val birthday: Date
	private val gender: Gender

	
	constructor(_name: String, _surname: String, _birthday: String, _gender String) {
		setName(_name);
		setSurname(_surname)
		setBirthday(_birthday)
		setGender(_gender)
	}
	
	
	/**
	Set the name.
	if the String is not compatible for Person name will be set to default value.
	
	@param _surname String rappresentation of name
	*/
	public setName(_name: String) {
		if(isValid(_name))
			name = _name;
		else
			name = DEFAULT_NAME
	}
	
	
	/**
	Get the name.
	
	@return return the value of the name
	*/
	public getName() = return name
	
	
	/**
	Set the surname.
	if the String is not compatible for Person surname will be set to default value.
	
	@param _surname String rappresentation of surname
	*/
	public setSurname(_surname: String) {
		if(isValid(_surname))
			surname = _surname
		else
			surname = DEFAULT_NAME
	}
	
	
	/**
	Get the surname.
	
	@return return the value of the surname
	*/
	public getSurname() = return surname
	
	
	/**
	Verify if a String is valid for a Person Object.
	
	@param str String that rapresent the name or surname of the Person
	@return return true if the String is valid
	*/
	private isValid(str: String?): Boolean {	
		str?.let {
			// se non è null
			return str.length()>MIN_LENGTH && !containsDigit(str)
		}
		
		return false		
		
		//return str!=null && str!!.length()>MIN_LENGTH && !containsDigit(str)
	}
	
	
	/**
	Set the birthday.
	if the String is not a valid date will be set to default value.
	
	@param date String rappresentation of the date
	*/
	public setDate(date: String) {
		if(isValidDate(date))
			birthday = Date(date)
		else
			birthday = DEFAULT_BIRTHDAY
	}
	
	
	/**
	Get the birthday
	
	@return return the value of the birthday
	*/
	public getBirthday() = return birthday
	
	
	/**
	Verify if a String not contain digit values.
	
	@param str String that will be verified
	@return return true if the String contains one or more digits
	*/
	private containsDigit(str: String): Boolean {
		for(c in str)
			if(c.isDigit())
				return true
		
		return false
	}
	

	/**
	Verify if a Date is valid
	
	@param date String thath rapresent the Date
	@return return true if the date is valid
	*/
	private isValidDate(date: String): Boolean {
		return true
		
		/*
		try {
			var formatter = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
			val date = formatter.parse(dateStr)			
		} catch(e: ParseException) {
			return false
		} finally {
			return true
		}
		*/
	}
	
	/**
	Set the gender.
	if the String is not a valid will be set to default value.
	
	@param _gender String rappresentation of the gender
	*/
	public setGender(_gender: String) {
		try {
			gender = Gender.valueOf(_gender.toLowerCase())
		}catch(e: Exception){
			gender = DEFAULT_SEX
		}
	}
	
	
	/**
	Get the gender
	
	@return return the value of the gender
	*/
	public getGender() = return gender
	
	
	/**
	Get a String rappresentation of the Person Object
	
	@return return a String rappresentation of the Person Object
	*/
	public toString(): String {
		var str = ""
		
		str += "name> ${getName()}\n"
		str += "surname> ${getSurname()}\n"
		str += "birthday> ${getBirthday().toString()}\n"
		str += "gender> ${getGender().toString()}\n"
		
		return str
	}

}