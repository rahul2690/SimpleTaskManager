import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ClarityModule } from '@clr/angular';
import { AppComponent } from './app.component';
import { ROUTING } from "./app.routing";
import { HomeComponent } from "./home/home.component";
import { TaskManagerComponent } from './task-manager/task-manager.component';

import { StoreModule } from '@ngrx/store';
import { reducer } from './task-manager/store/taskReducers';
import { EffectsModule } from "@ngrx/effects";
import {TaskEffects} from './task-manager/store/taskEffects';
import { TaskManagerApi } from "app/shared/routine";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { DatePipe } from "@angular/common";

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        TaskManagerComponent
    ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule,
        HttpModule,
        HttpClientModule,
    
        ClarityModule,
        ROUTING,
        EffectsModule.forRoot([ TaskEffects ]),
        StoreModule.forRoot({
            task: reducer
          })
    ],
    providers: [
        TaskManagerApi,HttpClient,DatePipe
      ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
