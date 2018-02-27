import { Component, OnInit } from '@angular/core';
import {UserService} from "../shared/user/user.service";
import {ActivatedRoute} from "@angular/router";
//import {DomSanitizationService, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'jhi-dashboard',
  templateUrl: './dashboard.component.html',
  styles: []
})
export class DashboardComponent implements OnInit {

    public url: string;
    private dashboardId: string;
    constructor(
      private userService : UserService,
      private route: ActivatedRoute
    ) { }

  ngOnInit() {
      this.url = "http://localhost:8080/test/";
      this.getDashboardURL();
  }

  getDashboardURL(){
      this.userService.getDashboard().subscribe( (id) => {
          if( id != null ) {
              this.dashboardId = id;
              this.url += this.dashboardId;
          }
      });
  }

}
