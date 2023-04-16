import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {StatusBean} from '../home/statusBean';

@Injectable({
  providedIn: 'root'
})
export class StatusService {

  private googleUrl = 'http://localhost:8080/v1/google-status';
  private amazonUrl = 'http://localhost:8080/v1/amazon-status';
  private allUrl = 'http://localhost:8080/v1/all-status';

  constructor( private httpClient:HttpClient) { }

  // Call Amazon REST endpoint
  getAmazonWebsiteStatus(): Observable<any> {
    return this.httpClient.get<StatusBean[]>(`${this.amazonUrl}`);
  }

  // Call Google REST endpoint
  getGoogleWebsiteStatus(): Observable<any> {
    return this.httpClient.get<StatusBean[]>(`${this.googleUrl}`);
  }

  // Call All Status REST endpoint
  getAllWebsiteStatus(): Observable<any> {
    return this.httpClient.get<StatusBean[]>(`${this.allUrl}`);
  }
  
}
