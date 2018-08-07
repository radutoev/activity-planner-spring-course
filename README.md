Activity Planner with Integrations (reserve hotel, book restaurant)

 - plan my day: go to gym, movies etc
 - integrations (buy tickets, book restaurant)
 - predefiend daily plans (adv): o serie de activitati facute de altcineva la o anumita


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