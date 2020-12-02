import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router, UrlHandlingStrategy } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';
import { AuthModel } from '../model/auth-model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  usuario: AuthModel;

  constructor(private cookieService: CookieService, protected router: Router, private http: HttpClient) { }

  async checktoken(token: string) {

      return await this.http.get<AuthModel>(environment.auth.checkTokenUrl + `?token=${token}`).toPromise();
    
  }

  login(usuario: string, senha: string) {

    let params = new HttpParams();
    params.append('username', usuario);
    params.append('password', senha);
    params.append('grant_type', 'password');
    params.append('client_id', "exampleClient");

    let auth = btoa(`${environment.auth.clientId}:${environment.auth.clientSecret}`);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + btoa(auth),
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
        'Access-Control-Allow-Credentials': 'true'
      })
    };

    return this.http.post<any>(`/api/oauth/token?grant_type=password&username=${usuario}&password=${senha}`, httpOptions);
  }


}
