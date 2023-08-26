### Hallo, hier programmiere ich eine Shop App, ich nutze viewBinding, dataBinding und werde nach der MVVM Architektur Bauen...

## I. Layout, Splash,Navigation,builg.gradle und Manifest:
### 1. Packages und benötigten Dateine nach Model-View-ViewModel erstellen
### 2. viewBinding und die Navigation aktivieren
### 3. SplashActivity definieren 
### 4. Layout von login und registrieren Fragment definieren
### 5. Navigation definieren
    + SplashActivity als Startpunkt festlegen, im Androidmanifest den intent Filter vom MainActivity Abschnitt in den SplashActivity Abschnitt verschieben
    + Von der SplashActivity.kt zur MainActivity navigieren, in der SplashActivity eine Progressbar hinzufügen um nach einer kurzen Verzögerung zur MainActivity zu navigieren
    + MainActivity als Host für Fragmente, einen FragmentContainerView hinzuzufügen, der als Host für die Fragmente dient
    + In der MainActivity, wird der LoginFragment zum FragmentContainerView hinzugefügt, wenn die Activity zum ersten Mal erstellt wird
    + im nav_graph.xml den Host Fragment setzen und die aktionen zwischen den Fragmenten definieren

## II. Login
    + Die Überprüfung der Anmeldedaten werden im LoginViewModel durchgeführt, indem die eingegebenen Anmeldedaten mit einer Liste von Benutzern verglichen werden, die im UserRepository definiert sind
        - LoginViewModel enthält die Logik zur Überprüfung der Benutzeranmeldeinformationen
        - LoginFragment verwendet LoginViewModel und LoginUtils zur Validierung und Navigation

### 1. In der class User die Anmelde Attribute festlegen und zur Data class ändern, damit die Methoden verwendet werden können:  toString(), equals(), (Mit Standardwerten muß man kein separaten Klassen oder Konstruktoren für die unterschiedlichen Anforderungen erstellen) 
### 2. Im UserRepository Datensätze zum login/registrieren erstellen/simulieren, damit man login/registrieren simulieren kann
### 3. Die ViewModel-Klassen verwenden das UserRepository, um auf die Daten zuzugreifen und die Logik/Überprüfungen für Login und Registrierung zu implementieren
### 4. In der utils.kt die benötigten Methoden definieren

## III. SharedPreferences: Registrieren, Profil speichern und über Login nutzen
### 1. UserRepository aktualisieren, loginUsers als veränderbare Liste zu deklarieren und eine Methode zum neuen Benutzers hinzuzufügen
### 2. In RegistrierViewModel.kt eine Methode hinzufügen, um einen neuen Benutzer zu registrieren
### 3. RegistrierenUtils erstellen, um die Benutzereingabe zu validieren
### 4. Änderungen im RegistrierenFragment 
    + SharedPreferences-Instanz namens sharedPreferences hinzugefügt
    + In der onViewCreated Methode die sharedPreferences initialisiert
    + Im OnClickListener für den Registrierungsbutton werden die Benutzerdaten in den SharedPreferences gespeichert
### 5. Änderungen im LoginFragment
    + onClickListener für Login und Registrieren setzen
    + Überprüfen ob die eingegebenen Daten mit den sharedPreferences übereinstimmen, oder mit den Daten in der UserRepository
### 6. Testen ob alles klappt, Methode 1 und 3 getestet - IT works!
    Methode 1, Über den Device File Explorer:
        + Unter View > Tool Windows > Device File Explorer öffnen
        + Navigationspfad zu data > data > [Dein App-Paketname] > shared_prefs
        + Auf die "MeinShopPrefs.xml" Datei, Rechtsklicken und  "Save As" auswähzlen, um die Registrierdaten Lokal zu speichern und den Inhalt anzusehen
    Methode 2, Über den Debugger:
        + Nachdem die Daten in SharedPreferences gespeichert sind, einen Breakpoint im code setzen
        + Die App im Debug-Modus starten und warten bis der Breakpoint erreicht wird
    Methode 3, Log-Ausgaben:
        + In der LoginFragment.kt, Logcat verwenden um das neu erstellte Profil zu überprüfen

## IV. 
### 1. 

        


