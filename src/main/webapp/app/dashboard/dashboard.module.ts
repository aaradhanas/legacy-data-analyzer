/**
 * Created by AAS on 2/18/2018.
 */
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BlogSharedModule } from '../shared';

import { DashboardComponent } from './dashboard.component';
import {DASHBOARD_ROUTE} from "./dashboard.route";
import {DashboardUrlPipe} from "./dashboard.url.pipe";


@NgModule({
    imports: [
        BlogSharedModule,
        RouterModule.forChild([DASHBOARD_ROUTE])
    ],
    declarations: [
        DashboardComponent,
        DashboardUrlPipe
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class BlogDashboardModule {}
