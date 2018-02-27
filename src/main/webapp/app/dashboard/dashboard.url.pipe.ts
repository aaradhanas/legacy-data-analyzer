import {Pipe, PipeTransform, SecurityContext} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";
/**
 * Created by AAS on 2/26/2018.
 */


@Pipe({ name: 'safeUrl'})
export class DashboardUrlPipe implements PipeTransform{

    constructor( private sanitizer: DomSanitizer){}

    /**
     * Bypass security and trust the given value to be a safe resource URL, i.e. a location that may
     * be used to load executable code from, like `<script src>`, or `<iframe src>`.
     *
     * **WARNING:** calling this method with untrusted user data exposes your application to XSS
     * security risks!
     */
    transform(url){
        return this.sanitizer.bypassSecurityTrustResourceUrl(url);
        //return this.sanitizer.sanitize(SecurityContext.URL, url);
    }
}
