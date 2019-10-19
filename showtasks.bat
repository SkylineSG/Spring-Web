call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runweb
echo.
echo RUNCRUD.BAT has errors - breaking work
goto fail

:runweb
http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open page
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo showtasks is finished.