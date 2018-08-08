Activity Planner with Integrations (reserve hotel, book restaurant)

 - plan my day: go to gym, movies etc
 - integrations (buy tickets, book restaurant)
 - predefiend daily plans (adv): o serie de activitati facute de altcineva la o anumita

### API

/appointments GET find all appointments
/appointments POST create an appointment
/appointments/{id} PUT update an app (i.e /appointment/1)
/appointments/{id} DELETE an appointment

/my-day - chronological list of appointments.

//sim a restaurant booking service.


-------------------
### HTTP Protocol

Response: Header, Body (optional)
   header: status codes: 2xx, 3xx, 4xx, 5xx
           content type: text/html; application/json

Request: header, body (optional)
   http verbs: GET, POST, PUT, DELETE


-------------------
### Dependency Injection

   ```
   class A {
       private B b; //composition

       public A(B b) {}
   }

   class B {
       private C c;

       public B(C c) { this.c = c; }
   }

   ///
   A a = new A(new B(new C())) //object hierarchy

   @Inject, @Autowired
   ```

-------------------

### Look into

* maven the build tool
* spring beans (scopes)
* builder pattern
* db migrations -> flyway
* REST API design (video)
* Look into bean validation (jsr 303)