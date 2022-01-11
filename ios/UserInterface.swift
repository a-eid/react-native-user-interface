import Foundation
import UIKit


@objc(UserInterface)
class UserInterface: NSObject {
    
    @objc(setUserInterface:style:)
    func setUserInterface(name: String, style: String) -> Void {
        print(name, style)
        if #available(iOS 13, *) {
          if let window = UIApplication.shared.delegate?.window {
            DispatchQueue.main.async {
                window?.overrideUserInterfaceStyle = style == "dark" ? .dark : style == "light" ? .light : .unspecified
            }
          }
        }
    }
}
