### Hallo, hier programmiere ich eine Shop App, ich nutze viewBinding, dataBinding und werde nach der MVVM Architektur Bauen...

## I. Layout, Splash,Navigation,builg.gradle und Manifest:
### 1. Packages und benötigten Dateine nach Model-View-ViewModel erstellen
### 2. viewBinding und die Navigation aktivieren
### 3. SplashActivity definieren 
### 4. Layout von login und registrieren Fragment definieren
### 5. Navigation definieren
    * SplashActivity als Startpunkt festlegen, im Androidmanifest den intent Filter vom MainActivity Abschnitt in den SplashActivity Abschnitt verschieben
    * Von der SplashActivity.kt zur MainActivity navigieren, in der SplashActivity eine Progressbar hinzufügen um nach einer kurzen Verzögerung zur MainActivity zu navigieren
    * MainActivity als Host für Fragmente, einen FragmentContainerView hinzuzufügen, der als Host für die Fragmente dient
    * In der MainActivity, wird der LoginFragment zum FragmentContainerView hinzugefügt, wenn die Activity zum ersten Mal erstellt wird
    * im nav_graph.xml den Host Fragment setzen und die aktionen zwischen den Fragmenten definieren


## II. Lokal- Shared Preferences: Login,Registrieren, Überprüfen, Konto, Bezahlen, Überprüfen der Daten etc...
### 1. In der class User die Anmelde Attribute festlegen und zur Data class ändern, damit die Methoden verwendet werden können:  toString(), equals() und hashCode()
### 2. Im UserRepository Datensätze zum login/registrieren simulieren und die Methoden zum überprüfen der Daten hinzufügen
### 3. Die ViewModel-Klassen verwenden das UserRepository, um auf die Daten zuzugreifen und die Geschäftslogik für Login und Registrierung zu implementieren
### 4. Verwendung in den Views, nun kan man die ViewModel-Klassen in den entsprechenden Views (Fragments oder Activities) für Login und Registrierung verwenden
