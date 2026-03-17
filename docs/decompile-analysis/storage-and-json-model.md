# Storage and JSON Model

This document outlines the types and structures used for storage and JSON modeling in the application.

## Model Types
- **User**: Holds user information.
- **Session**: Represents a user's session.
- **Data**: Stores application-relevant data.

## JSON Structures
- Each model is serialized into JSON format with the following structure:
  - **User**: `{ "id": "", "name": "", "email": "" }`
  - **Session**: `{ "sessionID": "", "userID": "", "timestamp": "" }`
  - **Data**: `{ "dataID": "", "content": "" }`

Make sure to adhere to these structures when implementing the data handling in your application.