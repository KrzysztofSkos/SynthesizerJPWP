# SynthesizerJPWP

## Zadanie 1

Spraw, aby przycisk z nazwą instrumentu powodował zmianę grającego instrumentu. 


## Zadanie 2

Spraw, aby głośność dźwięku zmieniała się wraz z pozycją slidera podczas jego trwania. 


## Zadanie 3

Przetestuj działanie M&K Synthesizer. Spróbuj zagrać kilka dźwięków jednocześnie.
Jak zausłyszałeś nie jest to możliwe. Nawet próba zagrania kilku dźwięków po sobie skutkuje
wybrzmieniem każdego z nich przez określony przez Box Time czas i dopiero wtedy zaczynamy słyszeć kolejny.
Wejdź do klasy SoundMaker. Zastanów się jak można poprawić kod, żeby możliwe było granie kilku dźwięków jednocześnie. 
Jest to możliwe, co więcej jest to dość kluczowa funkcja każdego syntezatora :). Dopisz odpowiednie linijki 
kodu i przetestuj program. Jeśli można grać jednocześnie kilka dźwięków naraz, to przejdź do kolejnego zadania.
  Wskazówki: nie trzeba modyfikować żadnej klasy oprócz SoundMaker.
  Nie trzeba też edytować napisanego już kodu, ale dodać coś nowego, z czym na pewno miałeś już do czynienia
  w Javie.


## Zadanie 4 

Przetestuj działanie efektu Tremolo w M&K Synthesizer. Na pierwszy rzut ucha wydaje się, że wszystko
działa dobrze. Ustaw Volume na maksymalną wartość i przetestuj działanie Tremolo na falach Sine i Triangle.
Teraz wyraźnie słychać zniekształcenia dźwięku. Nie chcemy tego. Wejdź do klasy Tremolo. 
Zastanów się co może to powodować, popraw kod i przetestuj teraz działanie Tremolo. 
Jeśli udało się zniwelować zniekształcenia dźwięku, przejdź do następnego zadania.
  Wskazówka: nie trzeba modyfikować żadnej klasy oprócz Tremolo.


## Zadanie 5

Na podstawie klasy Tremolo spróbuj napisać własny efekt w klasie NewEffect.
Funkcja getWave przyjmuje na wejściu tablicę bajtów o nazwie wave, która jest falą stworzoną wcześniej w klasie
WaveMaker o kształcie wybranym w GUI. Pozostałe parametry wejściowe to modulationOne i modulationTwo,
które będą kontrolować działanie efektu. Jeśli któryś z tych parametrów nie jest potrzebny, można go
nie wykorzystywać. Funkcja musi zwrócić tablicę bajtów, która będzie zmodulowaną przez NewEffect tablicą wave.
Efekt NewEffect jest już podpięty do GUI i klasy Keyboard, więc skup się tylko na przekształceniu fali.
Możesz skorzystać z wykładu profesora A. D. Marshalla z Cardiff University, w którym tłumaczy działanie
poszczególnych efektów, a nawet załącza kod efektów napisanych w języku Matlab.
Proponujemy napisanie któregoś z poniższych efektów:
- Flanger - dość prosty efekt oparty na opóźnieniu dźwięku (delay),
- Overdrive - prosty, łagodny przester,
- Fuzz - kolejny prosty, ale bardziej agresywny i nieobliczalny przester.

Oczywiście można wybrać jakikolwiek efekt. Trzeba mieć jednak na uwadze to, że niektóre mogą być bardziej czasochłonne.
Link do wykładu profesora Marshalla: http://users.cs.cf.ac.uk/Dave.Marshall/CM0268/PDF/10_CM0268_Audio_FX.pdf

Powodzenia!

