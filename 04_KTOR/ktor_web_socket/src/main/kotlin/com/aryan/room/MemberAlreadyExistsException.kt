package com.aryan.room

class MemberAlreadyExistsException : Exception(
    "Username already in use. Please select a different username."
)