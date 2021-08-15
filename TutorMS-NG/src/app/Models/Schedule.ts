export class Schedule {
    sundayStart: string;
    sundayEnd: string;
    mondayStart: string;
    mondayEnd: string;
    tuesdayStart: string;
    tuesdayEnd: string;
    wednesdayStart: string;
    wednesdayEnd: string;
    thursdayStart: string;
    thursdayEnd: string;
    fridayStart: string;
    fridayEnd: string;
    saturdayStart: string;
    saturdayEnd: string;
    pendingApprovalSince: string;
    
    constructor( sundayStart: string, sundayEnd: string, mondayStart: string,mondayEnd: string,
        tuesdayStart: string,tuesdayEnd: string,wednesdayStart: string,wednesdayEnd: string,thursdayStart: string,thursdayEnd: string,
        fridayStart: string,fridayEnd: string,saturdayStart: string,saturdayEnd: string, pendingApprovalSince: string){
            this.sundayStart = sundayStart;
            this.sundayEnd = sundayEnd;
            this.mondayStart = mondayStart;
            this.mondayEnd = mondayEnd;
            this.tuesdayStart = tuesdayStart;
            this.tuesdayEnd = tuesdayEnd;
            this.wednesdayStart = wednesdayStart;
            this.wednesdayEnd = wednesdayEnd;
            this.thursdayStart = thursdayStart;
            this.thursdayEnd = thursdayEnd;
            this.fridayStart = fridayStart;
            this.fridayEnd = fridayEnd;
            this.saturdayStart = saturdayStart;
            this.saturdayEnd = saturdayEnd;
            this.pendingApprovalSince = pendingApprovalSince;
    }
  }