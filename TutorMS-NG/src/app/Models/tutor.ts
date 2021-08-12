export class Tutor {
  id: number;
	firstName: string;
	lastName: string;
	userName: string;
	schoolEmail: string;
	password: string;
	phoneNumber: string;
	accountTypeId: number;

  constructor(id: number, firstName: string, lastName: string, userName: string, schoolEmail: string, password: string, phoneNumber: string, accountTypeId: number){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.schoolEmail = schoolEmail;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.accountTypeId = accountTypeId;

  }
}
  