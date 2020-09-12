# Servlet and Tomcat Support

I don't find a good title for this blog. Just want to summarize which version of Tomcat support which Servlet.


| Platform    | Servlet API version       | Released      | Specification| Tomcat Version| Important Changes of Servlet API|
| ----------- | -------------------       |-------------  | -----------  |-------------  | ----------- |
| Jakarta EE 9 | Jakarta Servlet 5.0.0 M1 |Jun 12, 2020   | 5.0          |10.0.x         | API moved from package javax.servlet to jakarta.servlet       |
| Jakarta EE 8 | Jakarta Servlet 4.0.3    |Aug 13, 2019   | 4.0          |10.0.x         | Renamed from "Java" trademark |
| Java EE 8    | Java Servlet 4.0         |Sep 2017       | JSR 369      |9.0.x          | HTTP/2 |
| Java EE 7    | Java Servlet 3.1         | May 2013      | JSR 340      |8.0.x(superseded) or 8.5.x|Non-blocking I/O, HTTP protocol upgrade mechanism (WebSocket)|
 |Java EE 6, Java SE 6| Java Servlet 3.0  | December 2009 | JSR 315      |7.0.x          |Pluggability, Ease of development, Async Servlet, Security, File Uploading|
 |Java EE 5, Java SE 5| Java Servlet 2.5  | Sep 2005      | JSR 154      |6.0.x (archived)|Requires Java SE 5, supports annotation[?]|
 
 Notes:
 1. I only organized the version since Servlet 2.5. It's rarely you'll use version lower than 2.5. 
 2. For Jakarta EE 8, I didn't see the actual changes, even the official specification. I downloaded, but the file is kind of empty. And there's no Tomcat support this version.
 Tomcat 10 directly support for Jakarta EE 9.
 3. TODO: Java Servlet 2.5 supports annotations: I need to test on this, definitely 3.0.1 supports annotations, didn't remember 2.5 version also.
 
 References:
 1. https://en.wikipedia.org/wiki/Jakarta_Servlet
 2. https://tomcat.apache.org/whichversion.html