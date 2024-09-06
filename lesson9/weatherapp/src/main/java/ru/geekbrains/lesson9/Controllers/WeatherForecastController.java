package ru.geekbrains.lesson9.Controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import ru.geekbrains.lesson9.Models.WeatherForecast;
import ru.geekbrains.lesson9.responses.ResourceStatusResponse;
import ru.geekbrains.lesson9.services.WeatherForecastHolder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class WeatherForecastController {

    private final WeatherForecastHolder weatherForecastHolder;

    @Autowired
    public WeatherForecastController(WeatherForecastHolder weatherForecastHolder) {
        this.weatherForecastHolder = weatherForecastHolder;
    }

    @Operation(summary = "Обновить данные о прогнозе погоды")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ресурс обновлен", content = {@Content(mediaType = "application/json", schema = @Schema(implementation=ResourceStatusResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Ошибка запроса"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PutMapping("update-data")
    public ResponseEntity<ResourceStatusResponse> update(
            @RequestParam LocalDate date,
            @RequestParam int temperatureC) {

        boolean result = weatherForecastHolder.update(date, temperatureC);

        if (result) {
            return ResponseEntity.ok(new ResourceStatusResponse("UPDATED", "Прогноз успешно обновлен"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResourceStatusResponse("ERROR", "Ошибка при обновлении прогноза"));
        }
    }

    @Operation(summary = "Добавить данные о прогнозе погоды")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ресурс создан",  content = {@Content(mediaType = "application/json", schema = @Schema(implementation=ResourceStatusResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Ошибка запроса"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping("add-data")
    public ResponseEntity<ResourceStatusResponse> add(
            @RequestParam LocalDate date,
            @RequestParam int temperatureC) {

        boolean result = weatherForecastHolder.add(date, temperatureC);

        if (result) {
            return ResponseEntity.ok(new ResourceStatusResponse("CREATED", "Прогноз успешно добавлен"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResourceStatusResponse("ERROR", "Ошибка при добавлении прогноза"));
        }
    }

    @Operation(summary = "Удалить данные о прогнозе погоды")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ресурс удален"),
            @ApiResponse(responseCode = "400", description = "Ошибка запроса"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @DeleteMapping("delete-data")
    public ResponseEntity<ResourceStatusResponse> delete(
            @RequestParam LocalDate date) {

        boolean deleted =  weatherForecastHolder.delete(date);

        if(deleted){
            return ResponseEntity.ok(new ResourceStatusResponse("DELETED", "Прогноз успешно удален"));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResourceStatusResponse("ERROR", "Ошибка при удалении прогноза"));
        }
    }

    @Operation(summary = "Получить данные о прогнозе погоды")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные получены",  content = {@Content(mediaType = "application/json", schema = @Schema(implementation=WeatherForecast.class))}),
            @ApiResponse(responseCode = "400", description = "Ошибка запроса"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping("get-data")
    public ResponseEntity<List<WeatherForecast>> get(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {

        try {
            List<WeatherForecast> result = weatherForecastHolder.get(from, to);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
