import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { CookieService } from 'ngx-cookie-service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  usuario: string;
  senha: string;

  constructor(public authService: AuthService, protected router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {
  }

  clickLogin() {
    this.authService.login(this.usuario, this.senha).subscribe(res => {
      this.cookieService.set("token", res.access_token);
       this.authService.checktoken(res.access_token).then(res => {
        this.authService.usuario = res;
        this.router.navigate(['/']);
      });
    });
  }

  clickCancelar() {
    this.router.navigate(['/']);
  }

}
