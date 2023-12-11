package com.ProjectFinalArhipovCalin.flyproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//sunt modele care ne ajuta sa comunicam cu controller, user
//mdelele sunt niste intermediare intre controller si entitatea noatra
//UserRequest poate fi User.java fara id. •
// DataTransferObject – se face un model ca sa putem comunica cu controllerul
// fara sa expunem User.java care este un table in db,
// pentru ca oricine ar sti sa comunice cu cntrolerul si am putea expune baza de date la diferite atacuri.
// Exepmlu de clasa din care se rescrie informatia din User: UserResponse.java
//* Nu vor fi nevoie de adnotari pentru entitate
//Parsam un obiect de tip UserRequest iar cind
// intoarcem un user din baza o sa parsam la UserResponse
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;

}
