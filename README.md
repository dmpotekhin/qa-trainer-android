# QA Trainer — Android App for Test Automation Training

Интерактивный Android-тренажёр для обучения написанию автотестов на **Appium** и **Kaspresso**.

## Стек

| Layer | Technology |
|-------|-----------|
| Language | Kotlin 1.9 |
| Min SDK | 26 (Android 8.0) |
| Target SDK | 34 (Android 14) |
| UI | XML layouts + View Binding + Material Design 3 |
| Navigation | Jetpack Navigation + BottomNavigationView |
| Tests | Kaspresso 1.5.5 (Kotlin), Appium 8.6 (Java + TestNG) |

## Быстрый старт

```bash
# 1. Клонировать
git clone <repo-url> qa-trainer-android
cd qa-trainer-android

# 2. Собрать APK
./gradlew assembleDebug

# 3. Скопировать APK для автотестов
./gradlew assembleAndCopyApk

# 4. APK будет в: automation/app/qa-trainer.apk
```

## Запуск тестов

### Kaspresso (Android Instrumentation)

```bash
# Все тесты
./gradlew connectedCheck

# Конкретный класс
./gradlew connectedCheck -Pandroid.testInstrumentationRunnerArguments.class=com.example.qatrainer.kaspresso.tests.BasicsTest
```

### Appium

```bash
# 1. Запустить Appium сервер
appium

# 2. Запустить тесты
cd automation/appium
mvn clean test -Dapp.path=../app/qa-trainer.apk -Dappium.url=http://127.0.0.1:4723
```

## Структура проекта

```
qa-trainer-android/
├── app/
│   ├── src/main/              # Исходный код приложения
│   │   ├── java/com/example/qatrainer/
│   │   │   ├── MainActivity.kt
│   │   │   └── ui/
│   │   │       ├── basics/    # Экран Basics
│   │   │       ├── forms/     # Экран Forms
│   │   │       ├── lists/     # Экран Lists + Detail
│   │   │       ├── gestures/  # Экран Gestures
│   │   │       └── challenges/# Экран Challenges
│   │   └── res/
│   │       ├── layout/        # XML layouts
│   │       ├── navigation/    # Nav graph
│   │       └── menu/          # Bottom nav menu
│   └── src/androidTest/       # Kaspresso тесты
│       └── java/com/example/qatrainer/kaspresso/
│           ├── screens/       # KScreen для каждого экрана
│           └── tests/         # Тестовые классы
└── automation/
    ├── appium/                # Appium тесты (Java + TestNG)
    │   ├── pom.xml
    │   ├── testng.xml
    │   └── src/test/java/com/example/qatrainer/
    │       ├── base/BaseTest.java
    │       ├── pages/         # Page Object Model
    │       └── tests/         # Тестовые классы (10 сценариев)
    └── app/                   # Куда копируется APK
```

## Экраны и тестовые сценарии

| Что учимся тестировать | Где в приложении | Kaspresso тест | Appium тест |
|------------------------|-----------------|----------------|-------------|
| Проверка отображения текста | Basics → Welcome | `test_allElementsDisplayed` | `testWelcomeText` |
| Accessibility ID / content-desc | Все экраны | Все KScreen проверяют View | `testWelcomeByAccessibility` |
| Switch (вкл/выкл) | Basics → Notifications | `test_switchToggle` | `testSwitchToggle` |
| RadioGroup (показать/скрыть) | Basics → Skill Level | `test_radioGroupShowsAdvancedLayout` | `testAdvancedRadioButton` |
| Ввод email + валидация | Forms → Email field | `test_emailValidationError` | `testEmailValidation` |
| DatePicker | Forms → Select Date | — | `testDatePicker` |
| Spinner / Dropdown | Forms → Country | — | — |
| Поиск в RecyclerView | Lists → Search | — | `testSearchInRecyclerView` |
| Pull-to-refresh | Lists → Swipe down | — | `testPullToRefresh` |
| Фильтрация (Chips) | Lists → Filter chips | `test_filterFavorites` | `testFilterFavorites` |
| Скролл RecyclerView | Lists | `test_scrollAndClickItem` | — |
| ViewPager (свайп) | Gestures → Swipe pages | — | `testSwipeViewPager` |
| Вертикальный скролл | Gestures → Long content | — | `testScrollContent` |
| Drag-and-drop | Gestures → Drag items | — | `testDragAndDrop` |
| Pinch-to-zoom | Gestures → Zoom area | — | — |
| Long-press → PopupMenu | Gestures → Zoom area | — | — |
| Double-tap → цвет фона | Gestures → Zoom area | — | — |
| AlertDialog | Challenges → Start → "Ready?" | `test_completeChallengeFlow` | `testFullChallengeFlow` |
| Snackbar | Challenges → after Start | — | — |
| Последовательность кнопок | Challenges → Green→Blue→Red | `test_completeChallengeFlow` | `testFullChallengeFlow` |
| Timer + ProgressBar | Challenges → Timer | `test_timerIsDisplayed` | `testTimerAccessibility` |
| FlakySafely (Kaspresso) | Challenges → Completed | `test_completeChallengeFlow` | — |

## Цветовая схема

Material Design 3: Indigo (`#4355B9`) / Deep Orange (`#FF6E40`). Тёмная и светлая темы.

## debug.keystore

Для подписи debug-сборок используй стандартный Android debug keystore:

```bash
keytool -genkey -v -keystore debug.keystore -alias androiddebugkey \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass android -keypass android \
  -dname "CN=Android Debug,O=Android,C=US"
```

Или скопируй стандартный из `~/.android/debug.keystore`.
