/**
 * Created by AAS on 2/18/2018.
 */

import { Route } from '@angular/router';

import { DashboardComponent } from './dashboard.component';

export const DASHBOARD_ROUTE: Route = {
    path: 'dashboard',
    component: DashboardComponent,
    data: {
        authorities: [],
        pageTitle: 'global.menu.dashboard.main'
    }
};
