import { Pipe, PipeTransform } from '@angular/core';
import { Tutor } from '../Models/tutor';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(tutors: Tutor[], searchBox: string): Tutor[] {
    
    if(!tutors || !searchBox){
      return tutors;
    }
    return tutors.filter(tutor => 
      tutor.firstName.toLocaleLowerCase().includes(searchBox.toLocaleLowerCase()) ||
      tutor.lastName.toLocaleLowerCase().includes(searchBox.toLocaleLowerCase())  
      );
  }

}
