# Prepare Windows 10 Vagrant Box for IE Web Testing

## Setup

1. execute `setup.sh`

2. setup Windows 10 manually.
    - enable WinRM and install Chocolatey

        ```bash
        # execute on PowerShell (as administrator)
        > winrm qc
        > net stop winrm
        > sc.exe config winrm start= auto
        > net start winrm

        > Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
        > cinst -y git googlechrome firefox
        ```

    - change firewall settings
    
        ```bash
        # execute on PowerShell (as administrator)
        > netsh advfirewall firewall add rule name="Open Port 22" dir=in action=allow protocol=TCP localport=22
        > netsh advfirewall firewall add rule name="Open Port 5985" dir=in action=allow protocol=TCP localport=5985
        > netsh advfirewall firewall add rule name="Open Port 5986" dir=in action=allow protocol=TCP localport=5986
        ```
    - install windows update tool

        ```bash
        # execute on PowerShell (as administrator)
        > Install-Module PSWindowsUpdate
        ```

    - Download JDK 8 and install.

    - set $JAVA_HOME
    
    - change timezone

    - update windows and cleanup
    
        ```bash
        # ssh login to vagrant box
        $ vagrant ssh
        
        # run PowerShell
        $ powershell
        
        # update Windows
        > Get-WindowsUpdate
        > Install-WindowsUpdate

        # cleanup
        > cleanmgr.exe /sageset:10 /sagerun:10 /setup /verylowdisk /d c
        > Clear-RecycleBin -force -ErrorAction:Ignore
        > c:/vagrant/vagrant_prepareation/SDelete/sdelete64.exe -z c:

        ```
        
        exit from vagrant box after that.

    - reload vagrant box for applying all changes
    
        ```bash
        $ vagrant reload
        ```

3. create vagrant package for testing
    ```bash
    $ vagrant package --base "win10_edge" --output "~/.vagrantbox/win10_edge_for_testing.box" --Vagrantfile ../Vagrantfile
    ```


## Expand Trial License (If Expired)
[reference](https://qxf2.com/blog/rearm-windows/)

```bash
# ssh login to vagrant box
$ vagrant ssh

# run PowerShell
$ powershell

# expand license
> slmgr -rearm

# check current license
> slmgr -dlv

# activate license
> slmgr -ato

```
