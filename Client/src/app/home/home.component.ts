import { Component, OnInit } from '@angular/core';
import { StatusService } from '../service/status.service';
import { StatusBean } from './statusBean';
import { timer, Subscription } from "rxjs";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  errorMessage: any;
  googleStatusResponse: StatusBean[];
  amazonStatusResponse: StatusBean[];
  allStatusResponse: StatusBean[];
  subscription: Subscription;

  constructor(private statusService:StatusService) { }

  ngOnInit() {
    // Get Amazon Status every minute
   this.subscription = timer(0, 60000).subscribe((res) => {this.getAmazonWebsiteStatus()});
   // Get Google Status every minute
   this.subscription = timer(0, 60000).subscribe((res) => {this.getGoogleWebsiteStatus()});
   // Get All Status every minute
   this.subscription = timer(0, 60000).subscribe((res) => {this.getAllWebsiteStatus()});
  }

  getAmazonWebsiteStatus(){
    this.statusService.getAmazonWebsiteStatus().subscribe((response:StatusBean[]) => {
      this.amazonStatusResponse = response;
    }, error => {
      this.errorMessage = error;
  });
  }

  getGoogleWebsiteStatus(){
    this.statusService.getGoogleWebsiteStatus().subscribe((response:StatusBean[]) => {
      this.googleStatusResponse = response;
    }, error => {
      this.errorMessage = error;
  });
  }

  getAllWebsiteStatus(){
    this.statusService.getAllWebsiteStatus().subscribe((response:StatusBean[]) => {
      this.allStatusResponse = response;
    }, error => {
      this.errorMessage = error;
  });
  }  

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
