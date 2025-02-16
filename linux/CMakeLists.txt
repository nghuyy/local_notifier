cmake_minimum_required(VERSION 3.10)
set(PROJECT_NAME "local_notifier")
project(${PROJECT_NAME} LANGUAGES CXX)

# This value is used when generating builds using this plugin, so it must
# not be changed
set(PLUGIN_NAME "local_notifier_plugin")

find_package(PkgConfig REQUIRED)
pkg_check_modules (NOTIFY REQUIRED IMPORTED_TARGET libnotify)

add_library(${PLUGIN_NAME} SHARED
  "local_notifier_plugin.cc"
)
apply_standard_settings(${PLUGIN_NAME})
set_target_properties(${PLUGIN_NAME} PROPERTIES
  CXX_VISIBILITY_PRESET hidden)
target_compile_definitions(${PLUGIN_NAME} PRIVATE FLUTTER_PLUGIN_IMPL)
target_include_directories(${PLUGIN_NAME} INTERFACE
  "${CMAKE_CURRENT_SOURCE_DIR}/include")
target_link_libraries(${PLUGIN_NAME} PRIVATE flutter)
target_link_libraries(${PLUGIN_NAME} PRIVATE PkgConfig::GTK)
target_link_libraries(${PLUGIN_NAME} PRIVATE PkgConfig::NOTIFY)

# List of absolute paths to libraries that should be bundled with the plugin
set(local_notifier_bundled_libraries
  ""
  PARENT_SCOPE
)
