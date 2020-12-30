/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.23).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.exception.BadInputException;
import io.swagger.exception.NotFoundException;
import io.swagger.model.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-21T13:18:37.550Z[GMT]")
public interface AccountApi {

    @Operation(summary = "Creates an account for a user", description = "", tags = {"accounts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created"),

            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @RequestMapping(value = "/account",
            consumes = {"application/json", "application/xml"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createAcc(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Account body, Errors errors) throws BadInputException, NotFoundException;


    @Operation(summary = "Get a specific account", description = "Calling this method will get you a specific bank account", tags = {"accounts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class)))),

            @ApiResponse(responseCode = "400", description = "bad input parameter"),

            @ApiResponse(responseCode = "403", description = "forbidden"),

            @ApiResponse(responseCode = "404", description = "accounts not found")})
    @RequestMapping(value = "/account/{accountId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Account> getAccountByIban(@Parameter(in = ParameterIn.PATH, description = "Id of account", required = true, schema = @Schema()) @PathVariable("accountId") String accountId) throws NotFoundException;


    @Operation(summary = "get all accounts", description = "Calling this method will get you a list of all the accounts from a user", tags = {"accounts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class)))),

            @ApiResponse(responseCode = "400", description = "bad input parameter"),

            @ApiResponse(responseCode = "403", description = "forbidden"),

            @ApiResponse(responseCode = "404", description = "accounts not found")})
    @RequestMapping(value = "/account/listaccount/{userId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Account>> getAccountByUserID(@Parameter(in = ParameterIn.PATH, description = "Id of user", required = true, schema = @Schema()) @PathVariable("userId") Long userId);


    @Operation(summary = "Changes account to inactive/active", description = "", tags = {"accounts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "Account not found")})
    @RequestMapping(value = "/account/activity/{accountId}",
            method = RequestMethod.PUT)
    ResponseEntity<Void> toggleStatusAcc(@Parameter(in = ParameterIn.PATH, description = "AccountID to set to active or inactive", required = true, schema = @Schema()) @PathVariable("accountId") String accountId);

}
